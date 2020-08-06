/*
8.6 Towers of Hannoi
*/

/*
Algorithm:
moveDisk(int n, Tower origin, Tower destination, Tower buffer){
	if (n<0) return;

	// move n-1 disks to buffer using destination as buffer
	moveDisks(n-1, origin, buffer, destination);

	// move top from origin to destination
	moveTop(origin, destination);

	moveDisks(n-1,buffer,destination, origin);
}
*/

void main(String[] args){
	int n =3;
	Tower[] towers = new Towers[n];
	for(int i=0;i<n;i++){
		towers[i] = new Tower[i];
	}

	for(int i=n-1,i>=0;i--){
		towers[0].add(i);
	}
	towers[0].moveDisks(n,towers[2], towers[1]);
}

class Tower {
	private Stack<Integer> disks;
	private int index;
	public Tower(int i){
		disks = new Stack<Integer>();
		index = i;
	}

	public void add(int d){
		if (!disks.isEmpty() && disks.peek() <= d){
			System.out.println("Error placing disk"+d);
		}else{
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t){
		int top = disks.pop();
		t.add(top);
	}

	public void moveDisks(int n, Tower destination, Tower buffer){
		if (n>0){
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			moveDisks(n-1, destination, this);
		}
	}
}