# rest-offer-service
A RESTful web service for a merchant to post and retrieve offers for sale. Each offer has a description and a price.

#### Available endpoints:
- Retrieve offer with specified `id`: `GET offers/id`
- Retrieve list of all offers:` GET offers`
- Create new offer: `POST offers`
- Delete offer with specified `id`: `DELETE offers/id`

Accepts JSON content of form
```
{"description": $DESCRIPTION, "price": $PRICE}
```
where `DESCRIPTION` is a string and `PRICE` is an integer.
