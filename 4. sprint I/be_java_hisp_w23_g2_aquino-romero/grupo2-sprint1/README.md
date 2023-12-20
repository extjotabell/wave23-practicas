# be_java_hisp_w23_g2 Project

## Name App: SocialMedia

This project is designed to provide a platform for users to connect, follow each other, and share posts. The project is implemented in Java and Spring Boot.

## Introduction
The be_java_hisp_w23_g2 project is a social platform that allows users to follow each other, share posts, and interact within the community.

## Features
- User registration and profile management
- Follow/unfollow other users
- Share posts with followers
- View posts from followed users
- Retrieve followers and followed users
- Count the number of followers for a specific user

## Endpoints
- [POST US-0001]
  - localhost:8080/users/{userId}/follow/{userIdToFollow}
  - Endpoint perform the “Follow” action to a user
  - Responsible: [Martin Lackington]
- [GET US-0002]
  - localhost:8080/users/{userId}/followers/count
  - Endpoint perform the “Count followers” action to a user
  - Responsible: [Felipe Costa]
- [GET US-0003]
  - localhost:8080/users/{userId}/followers/list
  - Endpoint perform the “List followers” action to a user
  - Responsible: [Felipe Costa]
- [GET US-0004]
  - localhost:8080/users/{userId}/followed/list
  - Endpoint perform the “List followed” action to a user
  - Responsible: [Claudia Vargas]
- [POST US-0005]
  - localhost:8080/products/post
  - Endpoint perform the “Create a Post” action to a user
  - Responsible: [Marcos Costanzo]
- [GET US-0006]
  - localhost:8080/products/followed/{userId}/list
  - Endpoint perform the “List the posts from follwed” action to a user
  - Responsible: [Clauida Vargas]
- [POST US-0007]
  - localhost:8080/users/{userId}/unfollow/{userIdToUnfollow}
  - Endpoint perform the “Unfollow user” action to a user
  - Responsible: [Jannett Aquino]
- [GET US-0008]
  - localhost:8080/users/{UserID}/followers/list?order=name_asc
  - Endpoint perform the “List the followers in alphabetic order” action to a user
  - Responsible: [Hernan De San Vicente]
- [GET US-0009]
  - localhost:8080/products/followed/{userId}/list?order=date_asc
  - Endpoint perform the “List the products from followed in date order” action to a user
  - Responsible: [Hernan De San Vicente]
- [POST US-0010]
  - localhost:8080/products/promo-post
  - Endpoint perform the “Carry out the publication of a new promotional product” action to a user
  - Responsible: [Jannett Aquino]
- [GET US-0011]
  - localhost:8080/products/promo-post/count?user_id={userId}
  - Endpoint perform the “Obtain the number of products on promotion from a certain seller” action to a user
  - Responsible: [Jannett Aquino]
- [GET US-0012]
  - localhost:8080/products/search-by-keyword/{keyword}
  - Endpoint perform the “Get posts from all sellers based on a keyword or letter that matches a category” action to a user
  - Responsible: [Jannett Aquino]

## Technologies Used
- Java
- Spring Boot
- Maven
- JSON (for data storage)

## Project Structure
![Project Structure](images/project-structure.png)

## Getting Started
Follow these steps to set up the project on your local machine.

### Prerequisites
Make sure you have the following installed:

Java (version 17)
Maven (version 3.9.5)

### Installation

### Clone the repository:
- git clone https://github.com/hdesanvicente/grupo2-sprint1.git
- cd grupo2-sprint1.git

### Build the project:
mvn clean install

### Run the application:
mvn spring-boot:run

### PostMan Collection
Group: [PostManCollection](src/main/resources/Sprint%201.postman_collection.json)
Individual: [PostManCollection](src/main/resources/Sprint%201%20-%20Individual.postman_collection.json)

### Technical Requirements 
[TechnicalRequirements](src/main/resources/3.%20b.%20Esp.%20de%20Req.%20técnicos%20funcionales%20-%20Sprint%20Nº%201%20-%20Spring%20(1).docx.pdf)



### Integers:
- Claudia Vargas
- Felipe Costa
- Hernan Martin De San Vicente
- Jannett Arami Aquino Romero
- Marcos Ezequiel Costanzo
- Martin Lackington

### Gratitude:
We would like to express our sincere gratitude to the following team and communities for their invaluable contributions and support during the development of this project:

- **[Equipo 2]:** [We extend our heartfelt gratitude to each member of the project team for their unwavering effort, dedication, and collaboration. This project wouldn't have been possible without the unique contributions of every individual.

Special thanks to our Scrum Master, [Johanna Tabella], whose leadership, guidance, and commitment to the Agile principles played a pivotal role in the success of this project. Your expertise and support have been invaluable throughout the development process.

We also want to express our appreciation to the wider open-source community for the wealth of knowledge and inspiration that fueled our journey.

Thank you all for your hard work and commitment to excellence.]

We are truly thankful for the open-source community and the wealth of knowledge and resources that have made this project possible. Your generosity and collaboration are greatly appreciated.
