Go to https://platform.openai.com/ 

Click on API Reference or go to https://platform.openai.com/docs/api-reference 

Go to Authentication Section then Click on API Keys or Go to https://platform.openai.com/docs/api-reference/authentication 

Create New Secret Key With Any Name: sk-9JocWFQEbxcvggghhjklllkFJMATAQz3QtJxrJzrx8nFc 


Open applicaiton.properties file 

Add below entries 

OPEN_AI_URL=https://api.openai.com/v1/completions 

OPEN_AI_KEY=sk-9JocWFQEbxcvggghhjklllkFJMATAQz3QtJxrJzrx8nFc 



Start Service 

Open any rest cient [Ex : Postman] 

URL : http://localhost:8080/api/searchchatgpt 

POST 

{ 
"query":"What is Springboot" 
} 




