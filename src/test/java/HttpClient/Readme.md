# Resolving unable to find valid certification path to requested target

## Step 1: Download site's certificate to local file system

a. navigate to "https://xxxx.yyyy.site
b. Click on "lock" icon in address bar
c. Select "Certificate" option
d. Go to details tab
e. click on "Copy to file" button
f. Click next button from "Welcome to the certificate export wizard'
g. Select ".DER encoded binary" as export file format
h. click on "Next"
i. browse and select the folder where this certificate needs to be copied

## Step 2: Update "cacerts" file with downloaded certificate

a. Navigate to "C:\Program Files\Java\jdk_version\jre\bin"

b. Execute following command to import certificate to cacerts
keytool -import -file C:\Path\to\folder\Certificate.cer -keystore "C:\Program Files\Java\jdk1.8.0_212\jre\lib\security\cacerts" -storepass "changeit"

### all done
 

