/*
7.7 Chat Server
*/

Features:
- Signing online and offline
- Add requests (sending, accepting and rejecting)
- Updating a status message
- Creating private and group chats
- Adding new messages to private and group chats.

Core components: Database, set of clients and set of servers

Database: for permanent storage of user list and chat archives.
Communication: XMLcan be used for communication between client and server.
Server: dats split across machines, requiring us to potentially hop from machine
		to machine. Prevent single point of failure.

Key Objects: user,conversations and status message		

// Usermanager manages the user actions
public class UserManager {
	private static UserManager instance;
	// maps from user id to user
	private HashMap<Integer, User> usersById;

	// maps from account name to user
	private HashMap<String, User> usersByAccountName;

	// maps from user id to online user
	private HashMap<Integer, User> onlineUsers;

	public static UserManager getInstance(){
		if (instance==null) instance = new UserManager();
		return instance;
	}

	public void addUser(User fromUser, String toAccountName){}
	public void approveAddRequest(AddRequest req){}
	public void rejectAddRequest(AddRequest req){}
	public void userSignedOn(String accountName){}
	public void userSignedOff(String accountName){}
}

public class User {
	private int id;
	private UserStatus status = null;

	// maps from other participant's user id to the chat
	private HashMap<Integer, PrivateChat> privateChats;

	// list of group chats
	private ArrayList<GroupChat> groupChats;

	/*
	receivedAddRequest notifies User B that User A has requested
	to add him. User B approve or rejects the request 
	(via UserManager.approveAddReuest) and the UserManager takes
	care of adding users to each other's contact.
	*/
	// maps from other person's user if to add request
	private HashMap<Integer, AddRequest> receivedAddRequests;

	private HashMap<Integer, AddRequest> sentAddRequests;	

	//maps from user id to user object
	private HashMap<Integer, User> contacts;

	private String accountName;
	private String fullName;

	public User(int id, String accountName, String fullName){}
	public boolean sendMessageToUser(User to, String content){}
	public boolean sendMessageToGroup(int id, String cnt){}
	public void ssetStatus(UserStatus status){}
	public boolean addContact(User user){}
	public void receivedAddRequest(AddRequest req){}
	public void sentAddRequest(AddRequest req){}
	public void reequestAddUser(String accountName){}
	public void addConversation(PrivateChat conversation){	
}

public abstract class Conversation {
	protected ArrayList<User> participants;
	protected int id;
	protected ArrayList<Message> messages;

	public ArrayList<Message> getMessages()
	public void addMessage(Message m){}
	public int getId(){}
}

public class GroupChat extends Conversation {
	public void removeParticipant(User user){}
	public void addParticipant(User user){}
}

public class PrivateChat extends Conversation {
	public PrivateChaar(User user1, User user2) {}
	public User getOtherParticipant(User primary) {}
}

public class Message {
	private String content;
	private Date date;
	public Message(String content, Date date){}
}

public class AddRequest {
	private User fromUser;
	private User toUser;
	private Date date;
	RequestStatus status;

	public AddRequest(User from, User to, Date d){}
}

public class UserStatus {
	private String message;
	private UserStatusType type;

	public UserStatus(UserStatusType type, String message){}
}

public enum UserStatusType {
	Offline, Away, Idle, Available, Busy
}

public enum RequestStatus {
	Unread, Read, Accepted, Rejected;
}
