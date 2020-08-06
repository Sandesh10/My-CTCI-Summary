How to approach OO Design:

Step 1: Handle Ambiguity
	When being asked Object-oriented Design question, you should inquire who is going to use it and how they are going to use it. 
	6 W's : Who, What, Where, When, How, Why

Step 2: Define the Core Objects
	Eg: Suppose we are asked to do the object-oriented design for a restaurant. Our core objects might be things like: Table, Guest, Party, Order, Meal, Employee, Server, and Host.

Step 3: Analyze Relationships (between objects)
	For eg: in a restaurant question, we may come up with the following design.
	- party should have an array of Guests.
	- Server and Host inherit from Employee.
	- Each Table has one Party, but each Party may have multiple Tables.
	- There is one Host for the Restaurant.

Step 4: Investigate Actions:
	Check if you have forgotton some objects and you will need to update your design.

	For eg: a Party walks into the Restaurant, and a Guest requests a Table from the Host. The Host looks up the Reservation and if it exists, assigns the Party to a Table. Otherwise, the Party is added to the end of the list. When a Party leaves, the Table is freed and assigned to a new Party in the list.

Design Patters:
- Singleton Class
- Factory Method

Singleton Class:
- ensures that a class has only one instance
- ensures access to the instance through the application.
- It is useful in cases where you have a "global" object with exactly one instance.
For eg:
	public class Restaurant{
		private static Restaurant _instance= null;
		protected Restaurant(){ ... }
		public static Restaurant getInstance(){
			if (_instance==null){
				_instance = new Restaurant();
			}
			return _instance;
		}
	}

- Not everyone like Singleton Design pattern, even calling it an "anti-pattern". One reason for thiss is that it can interface with unit testing.


Factory Method:
- offers an interface for creating an instance of a class, with its subclasses deciding which class to instantiate.
- Implementation: creator class being abstract and not providing an implementation for the Factory method. Or concrete Creator class that provides an implementaion for the Factory method. 
For eg:
	public class CardGame{
		public static CardGame createCardGame(GameType type){
			if(type == GameType.Poker){
				return new PokerGame();
			}else return new OtherGame();
		}
	} 
 	
