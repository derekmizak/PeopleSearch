package peoplesearch;

import ie.ucd.forlang.neo4j.EmbeddedGraphManager;
import ie.ucd.forlang.neo4j.GraphManager;
import ie.ucd.forlang.neo4j.object.EmailAccountImpl;
import ie.ucd.forlang.neo4j.object.PersonImpl;
import ie.ucd.forlang.neo4j.object.TwitterAccountImpl;


import java.io.File;
import java.util.Date;

public final class Main_Neo {

	public static void main(String[] args) {
		try {
			GraphManager mgr = EmbeddedGraphManager.getInstance();
			mgr.init(new File("/usr/local/Cellar/neo4j/2.1.7/libexec/data/forlang.db"));
			mgr.addPerson(new PersonImpl("John Doe"));
			mgr.linkPersons(new PersonImpl("Kevin D'Arcy"), new PersonImpl("Joe Bloggs"));
			mgr.linkPersonToEmailAccount(new PersonImpl("Jane Doe"), new EmailAccountImpl("jane@doe.com"));
			mgr.linkPersonToTwitterAccount(new PersonImpl("Joe"), new TwitterAccountImpl(new Date(), "desc", 1, 2, true,
					"loc", "sname", 22));
			mgr.destroy();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}