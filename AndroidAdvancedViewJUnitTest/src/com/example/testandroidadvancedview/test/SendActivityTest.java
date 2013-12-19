package com.example.testandroidadvancedview.test;

import com.example.junittest.ReceiveActivity;
import com.example.junittest.SendActivity;
import com.example.testandroidadvancedview.R;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;

public class SendActivityTest extends
		ActivityInstrumentationTestCase2<SendActivity>
{
	private SendActivity mSendActivity = null;

	public SendActivityTest()
	{
		super(SendActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		// TODO Auto-generated method stub
		super.setUp();
		mSendActivity = getActivity();
	}

	@Override
	protected void tearDown() throws Exception
	{
		// TODO Auto-generated method stub
		super.tearDown();
	}

	@MediumTest
	public void testSendMessageToReceiverActivity()
	{
		final Button sendToReceiverButton = (Button) mSendActivity
				.findViewById(R.id.button1);

		final EditText senderMessageEditText = (EditText) mSendActivity
				.findViewById(R.id.editText1);

		ActivityMonitor receiverActivityMonitor = getInstrumentation()
				.addMonitor(ReceiveActivity.class.getName(), null, false);

		TouchUtils.clickView(this, sendToReceiverButton);
		ReceiveActivity receiverActivity = (ReceiveActivity) receiverActivityMonitor
				.waitForActivityWithTimeout(1000);

		assertNotNull("ReceiverActivity is null", receiverActivity);
		assertEquals("Monitor for ReceiverActivity has not been called", 1,
				receiverActivityMonitor.getHits());
		assertEquals("Activity is of wrong type", ReceiveActivity.class,
				receiverActivity.getClass());

		getInstrumentation().removeMonitor(receiverActivityMonitor);
		
		getInstrumentation().runOnMainSync(new Runnable() {
		    @Override
		    public void run() {
		        senderMessageEditText.requestFocus();
		    }
		});
		getInstrumentation().waitForIdleSync();
		getInstrumentation().sendStringSync("Hello Android!");
		getInstrumentation().waitForIdleSync();
	}
}
