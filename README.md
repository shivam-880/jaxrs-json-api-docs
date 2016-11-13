# jaxrs-json-apidocs
A Java library to generate API documentation in JSON format for JAX-RS annotated classes.

--

**Sample Input**

``` java
@Path("/messenger")
public interface MessageResourceI {
	
	@GET
	@Path("/messages")
	@Produces("application/json")
	public Response getMessages(@QueryParam("messageId") int messageId);

}
```


**Sample Output**

```
{
    "resources": [{
        "path": "/messenger/messages",
        "requests": [{
            "verb": "javax.ws.rs.GET",
            "produces": ["application/json"],
            "parameters": [{
                "title": "messageId",
                "type": "int"
            }]
        }]
    }]
}
```

<br/>

> It currently is capable of parsing only limited JAX-RS annotations. Also, API documentation design is still under consideration.
