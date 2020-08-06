public class Jukebox {
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
	private SongSelector ts;

	private Jukebox(CDPlayer cdPlayer,
		User user, Set<CD> cdCollection, SongSelector ts) {}

	public Song getCurrentSong() {return ts.getCurrentSong();}
	public void setUser(User u) {this.user = u;}
}

/*
the CDPlayer class supports storing just one CD 
at a time. The CDs that are not in play are stored
in the jukebox.
*/
public class CDPlayer {
	private Playlist p;
	private CD c;

	// Constructors
	public CDPlayer(CD c, Playlist p) {}
	public CDPlayer(Playlist p) {this.p = p;}
	public CDPlayer(CD c) {this.c = c;}

	// Play song
	public void playSong(Song s) {}

	// Getter setter
	public Playlist getPlaylist() {return p;}
	public void setPlaylist(Playlist p){ this.p = p;}

	public CD getCD() {return c;}
	public void setCD(CD c){this.c =c;}
}

public class Playlist {
	private Song song;
	private Queue<Song> queue;
	public Playlist(Song song, Queue<Song> queue) {}

	public Song getNextStoPlay() {
		return queue.peek();
	}

	public void queueUpSong(Song s){
		queue.add(s);
	}
}

public class CD {/* data for id, artist, songs etc.*/}

public class Song {/* data for id, CD(could be null), title, length */}

public class User {
	private String name;
	private long ID;
	public String getName() {return name;}
	public void setName(String name){this.name = name;}
	public long getID() {return ID;}
	public void setID(long ID){ this.ID = ID;}
	public User(String name, long ID) {}
	public static User addUser(String name, long ID) {}
}
