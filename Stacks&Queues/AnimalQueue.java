import java.util.*;

abstract class Animal{
	private int order;
	protected String name;

	public Animal(String s){
		this.name = s;
	}

	public void setOrder(int i){
		this.order = i;
	}

	public int getOrder(){
		return this.order;
	}

	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder();
	}
}

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();

	private int order=0;

	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		Dog d = dogs.peek();
		Cat c =  cats.peek();
		if (a instanceof Dog){
			dogs.addLast((Dog) a);
		}else if (a instanceof Cat){
			cats.addLast((Cat) a);
		}
	}	

	public Animal dequeue(){
		if (dogs.size()==0){
			return cats.poll(); // remove the first element of cats.
		}else if (cats.size()==0){
			return dogs.poll(); // remove first element
		}
		Dog d = dogs.peek();
		Cat c =  cats.peek();
		if (d.isOlderThan(c)){
			return dogs.poll();
		}else{
			return cats.poll();
		}
	}

	public static void main(String[] args){
		AnimalQueue handle = new AnimalQueue();
		Dog d1 =  new Dog("Oliver");
		Cat c1 = new Cat("Cat1");
		Cat c2 = new Cat("Cat2");
		Cat c3 = new Cat("Cat3");
		Dog d2 =  new Dog("Dog2");
		handle.enqueue(d1);
		handle.enqueue(c1);
		System.out.println(handle.dequeue().name);
		handle.enqueue(c3);
		handle.enqueue(c2);
		handle.enqueue(d2);
		System.out.println(handle.dequeue().name);
		System.out.println(handle.dequeue().name);
		System.out.println(handle.dequeue().name);
		System.out.println(handle.dequeue().name);
	}	
}

class Dog extends Animal {
	public Dog(String d) {super(d);}
}

class Cat extends Animal {
	public Cat(String c) { super(c);}
}
