/*
7.2 Call Center:

Imagine you have a call center with three levels of employees: 
respondent, manager, and director. An incoming telephone call 
must be first allocated to a respondent who is free. If the
respondent can't handle the call, he or she must escalate the 
call to a manager. If the manager is not free or not able to 
handle it, then the call should be escalated to a director. 

Design the classes and data structures for this problem. 
Implement a method dispatchCall() which assigns a call to
the first available employee.
*/

/*
Approach:
Since all there levels of employees have different work to be done,
those specific functions are profile specific. We should keep these 
things within their respective class.

There are few things which are common like name, address, job titel and
age. These things can be kept in one class and can be extended or  inherited
by others.

Finally, there should be one CallHandler class which would route the calls to the
correct person.
*/

public class CallHandler {
	// 3 levels of employees.
	private final int LEVELS = 3;

	// Initialize 
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;

	/*
	employeeLevels[0] = respondents;
	employeeLevels[1] = managers;
	employeeLevels[2] = directors;
	*/
	List<List<Employee>> employeeLevels;

	/* queues for each call's rank */
	List<List<Call>> callQueues;

	public CallHandler() {}

	// Get the first available employee who can handle this call
	public Employee getHandlerForCall(Call call){ }

	// Routes the call to available employee or saves in a queue
	public void dispatchCall(Caller caller){
		Call call = new Call(Caller);
		dispatchCall(call);
	}

	public void dispatchCall(Call call){
		Employee emp = getHandlerForCall(call);
		if (emp != null){
			emp.receiveCall(call);
			call.setHandler(emp);
		}else {
			call.reply("Please wait");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}

	// An employee got free. Look for waiting call that employee can serve
	public boolean assignCall(Employee emp) {}
}	

Call represents call from a user. A call has a minimum rank and is assigned to
first employee who can handle it.

public class Call {
	// minimum rank of employee who can handle this call
	private Rank rank;

	// person who is calling
	private Caller caller;

	// employee who is handling call
	private Employee handler;

	private Call(Caller c){
		rank = Rank.Respondent;
		caller = c;
	}

	// set employee who is handling call
	public void setHandler(Employee e){
		handler = e;
	}

	public void reply(String message){}
	public Rank getRank() { return rank; }
	public void setRank(Rank r){ rank = r;}
	public Rank incrementRank() {}
	public void disconnect() {}	
}

/*Employee is a super call for the three levels. It is implemented as an
abstract class since there should be no reason to instantiate an Employee directly.
*/

abstract class Employee{
	private call currentCall = null;
	protected Rank rank;

	public Employee(CallHandler handler){}

	// start conversation
	public void receiveCall(Call call){}

	// issue is resolved, finish the call
	public void callCompleted(){}

	//issue not completed
	public void escalateAndReassign(){}

	// assign new call
	public boolean assignNewCall(){}

	// return whether the employee is free
	public boolean isFree(){
		return currentCall == null;
	}

	public Rank getRank() {return rank;}
}

class Director extends Employee {
	public Director() {
		rank = Rank.Director;
	}
}

class Manager extends Employee {
	public Manager() {
		rank = Rank.Manager;
	}
}

class Respondent extends Employee {
	public Respondent() {
		rank = Rank.Respondent;
	}
}