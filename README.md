# References

https://medium.com/better-programming/how-to-set-up-a-local-dynamodb-in-a-docker-container-and-perform-the-basic-putitem-getitem-38958237b968


IoT and Lambda Function creation 

Login to AWS Console
Services -> Internet of Things -> IoT core


Create Thing		
	Goto Manage -> Things 
	Click on "Create" on right top
	Give Name to thing

	Select/Create/ a Type. Optional - can be empty. 
		Create Type 
			Click "Create Type". Give name and desc, add attributes like Manufacturer/ model etc.,
			Click on "Create Thing Type".

	Select/Create/ a Group. Optional - can be empty. Contains info like Manufacturer/ model etc.,
		Create Group
			Click on "Create Group". Give name and desc, add attributes like Manufacturer/ model etc.,
			Click on "Create Thing Group".

	Add attributes to search thing. Optional - can be empty. Contains info like Manufacturer/ model etc.,
	Click on "Next" 

	Create Certificate
		Choose One-click certificate creation (recommended) and click on "Create Certificate"
		
	Download cert.pem, public.key and private.key files (These won't be available later)
	Download root CA for AWS IoT 
		Click on Download after root CA
		Choose any of the Endpoints and click(Opens new tab)
		Copy the content and create a file with name root-CA.crt.
		Paste the content to root-CA.crt file
		Change the extension of pem file from .pem.crt.txt -> .pem

	These files to configure the THING created.

	Activate Thing by clicking on "Activate" button
	Click On "Done"


Creating Policy 
	IoT Core -> Secure -> Policies
	Click on Create from Right top
	Give name to policy 
	Add a Statement.
		In Action, Give iot:*
		In Resource ARN, Goto Manage -> Things, select created Thing, you can find Thing ARN in "Details" menu. Paste it here.
		In Effect, Select Allow
		Click on Create


Attaching Policy to Thing
	Goto Security menu(Lists all certificate attached to this thing)
	Click on one certificate listed, You will be moved to certificates details page
	Click on "Policies"
	Click on Actions Dropdown at righ top corner
	Select "Attach Policy" (Lists all the policies created)
	Select policy 
	Click on "Attach"


Creating Lambda for Thing
	Services -> compute -> Lambda -> Functions
	Click on Create Function at Top Right corner
	Select Auther from Scratch
	Give Function Name
	Select Language needed (Ex : Java8)
	
	Create IAM Role to give permission
		Service -> IAM -> Roles
		Click on Create Role 
		Choose AWS Service
		Choose AWS Services to make accessable to Lambda Function(Ex: DynamoDB, EC2, S3)
		Click on Next: Permissions
		Attach Permission Policies 
		Click on Next: Tags
		Add Tags for identifying user etc., (Optional)
		Click on Next: Review
		Give Role name
		Click on Create Role
		
	Under Permissions, Choose/Create Role (IAM Role)
	Choose Use an exising role
	Select the role created previously
	Click on Create Function

	
Configuring Lambda functions with Thing
	There will be two pannels for lambda function
	One is trigger (Ex : AWS IoT)
	Other is list of policies (You can change the policies to give more permissions)
	On left side, under Triggers, choose AWS IoT
	Scroll Down to configure Thing
	select Custom IoT Role 
	Create Rule 
		Give name and Description
		Give Rule Query as SELECT * FROM '<THING_TOPIC>' - THING_TOPIC(Name/ Topic of thing)
	Select Enable Trigger
	Click on Add
	Click on Save at Top Right corner


Uploading Java jar for Lambda Function
	Click on Lambda Function Created
	Scroll Down and find Function Code Section
	Select Upload a .zip or .jar file from dropdown
	For Runtime choose java 8
	In Handler, give executable class path and method to be executed (including whole package structure ex : com.company.TestLambda::handleRequest)
	Click on Upload to select jar file
	Click on Save on Top Right corner
	
	
	




