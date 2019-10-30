// responsible for storing all contact info of a single person
// this is a more advanced data type that can store a few strings in 1 variable
class Contact {
    String name;
    String email;
    String phoneNumber;
}

// responsible for adding and searching for contacts
class ContactManager {
    Contact[] myFriends;
    int friendsCount;
    // default constructor
    ContactManager() {
        this.myFriends = new Contact[500];
        this.friendsCount = 0;
    }
    // method to add a Contact object to the Contact array - myFriends
    // since we donot return any variable from method we use void
    void addContact(Contact contact) {
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    // method to search through the array using name and return a Contact object once match found
    Contact searchContact(String user_name) {
        for (int i=0; i<friendsCount; i++) {
            if (myFriends[i].name.equalsIgnoreCase(user_name)) {
                return myFriends[i];
            }
        }
        return null;
    }
}

class oop{
    public static void main(String[] args) {
        ContactManager myContacts = new ContactManager();
        Contact contactOne = new Contact();
        Contact contactTwo = new Contact();
        contactOne.name = "Subham";
        contactTwo.name = "Sumit";
        contactOne.email = "subham@gmail.com";
        contactTwo.email = "sumitkb@gmail.com";
        contactOne.phoneNumber = "8910414590";
        contactTwo.phoneNumber = "1234567890";

        myContacts.addContact(contactOne);
        myContacts.addContact(contactTwo);
        Contact result = myContacts.searchContact("sUbham");
        if (result == null) {
            System.out.println("No such contact in list");    
        } else {
            System.out.println(result.email);
    
        }
    }
}

    




