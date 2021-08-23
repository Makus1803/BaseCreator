# Customer Base Creator

The application allows you to keep a customer database. It also allows you to check whether the email address is working and whether the email messages will be received.  In addition, it allows you to add "patterns" of addresses and check several at once, after entering the name, surname and domain.


# Endpoints
### Swagger
Swagger is avaliable at enpoint: `/swagger-ui/`
There you can check all avaliable end points, parameters and test responses

1. Auth Controller: 
	- Registration 
	`/api/auth/signup`
	- Login
	`/api/auth/signin`
2.  Client Controller
	- Add Client
	`/api/client/add`
	- Add Clients From CSV
	`/api/client/add/csv`
	- Get All Clients
	`/api/client/get/all`
	- Get Clients From CSV
	`/api/client/get/csv`
3. Mail Controller
	- Add Mail
	`/api/mail/add/option`
	- Check All Mails
	`/api/mail/check/all-mails`
	- Check One Mail
	`/api/mail/check/one-mail`
	- Get All Mail Pattern
	`/api/mail/get/all-pattern`
	- Get All Decoded Pattern
	`/api/mail/get/decoded-pattern`
4. Message Controller
	- Add Message Pattern
	`/api/mail/pattern/add`
	- Get All Message Patterns
	`/api/mail/pattern/all`
	- Decode Pattern
	`/api/mail/pattern/decode`
	- Decode All Pattern
	`/api/mail/pattern/decode-all`
	- Add Value Map
	`/api/mail/value-map/add`
	- Get Value Map
	`/api/mail/value-map/get`

