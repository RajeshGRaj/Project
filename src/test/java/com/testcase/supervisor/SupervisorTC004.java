package com.testcase.supervisor;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;

public class SupervisorTC004 extends AllScenario {
	
	public void verify() throws IOException, InterruptedException, AWTException {
		
		OpenTabAndLaunchURL(1, configloader().getProperty("EnduserURL"));
		webchat.clickChat();
		webchat.clickChatWithUs();
		
		String firstname = fakedata.getFirstName();
		String email = fakedata.getEmail();
		
		webchat.enterFirstName(firstname);
		webchat.enterEmail(email);
		webchat.clickSubmit();
		//WebChat Ends
		
		//Agent
		SwitchToTab(0);
		routedchat.clickQuickActionAccept(firstname);
		routedchat.enterMyChatSearch(firstname);
		routedchat.clickOpenArrow(firstname);
		String message = fakedata.getMessage();
		routedchat.enterMessage(message);
		routedchat.clickSend();
		//Agent End
		
		//Supervisor Login
		OpenTabAndLaunchURL(2, configloader().getProperty("GeneralURL"));
		login.enterUsername(configloader().getProperty("Supervisor_UserName"));
		login.enterPassword(configloader().getProperty("Supervisor_Password"));
		login.enterCaptcha();
		login.clickLogin();
		//Supervisor End
		
		//Agent Tab
		SwitchToTab(0);
		routedchat.clickEscalate();
		routedchat.selectEscalationSupervisor("nuon arunmeanith");
		routedchat.selectEscalationCategory("iustoharum");
		routedchat.selectEscalationSubCategory("sit");
		routedchat.enterComment("Escalating Chat to Specific Supervisor");
		routedchat.clickSubmit();
		ToastDisplayed("Chat escalated successfully...");
		//End Agent
		
		//Supervisor
		SwitchToTab(2);
		supervisorChat.clickEscalatedChatOpen(firstname);
		//Supervisor End
		
		//EndUser
		SwitchToTab(1);
		SwitchToFrame();
		String enduserMSG = "From Enduser Message";
		webchat.enterMessage(enduserMSG);
		webchat.clickSend();
		Thread.sleep(2000);
		//Enduser End
		
		//Supervisor
		SwitchToTab(2);
		Thread.sleep(2000);
		assertEquals(GetElementText(routedchat.L_card_message), enduserMSG);
		//endSupervisor
		
		
		SwitchToTab(0);
	}

}
