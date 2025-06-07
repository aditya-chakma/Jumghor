## User Service API

This service manages user accounts.

**Base URL:** `/v1/users`

### Endpoints

#### 1. Get All Users

*   **Method:** `GET`
*   **Path:** `/`
*   **Description:** Retrieves a list of all users.
*   **Response:**
    *   **Success (200 OK):**  Returns a list of `UserDto` objects.

    **`UserDto` Structure:**

    ```json
    {
      "id": 123,  // (long) Unique user ID
      "userName": "john.doe",  // (String) Username
      "displayName": "John Doe",  // (String) Display name
      "email": "john.doe@example.com"  // (String) Email address
    }
    ```

#### 2. Get User by ID

*   **Method:** `GET`
*   **Path:** `/{user_id}`
*   **Description:** Retrieves a specific user by their ID.
*   **Parameters:**
    *   `user_id` (path parameter, required): The ID of the user to retrieve.
*   **Response:**
    *   **Success (200 OK):** Returns a `UserDto` object for the specified user.
    *   **Error:** If the user does not exist, the API currently returns `null`. (Consider returning a 404 Not Found).

#### 3. Create User

*   **Method:** `POST`
*   **Path:** `/`
*   **Description:** Creates a new user account.
*   **Request Body:** A `UserDto` object containing the user details.  Example:
    ```json
    {
      "userName": "newuser",
      "displayName": "New User",
      "email": "newuser@example.com",
      "password": "secure_password"  // Password (write-only - not returned in responses)
    }
    ```
*   **Response:**
    *   **Success (200 OK):** Returns the created `UserDto` (without the password).

#### 4. Update User

*   **Method:** `PATCH`
*   **Path:** `/`
*   **Description:** Updates an existing user's information. Note: It appears this endpoint uses `userName` to identify the user to update, which might be problematic if usernames can change.  Consider using the user ID for identification.
*   **Request Body:** A `UserDto` object with the fields to update. Example (assuming you can update any field):
    ```json
    {
      "userName": "john.doe", // (Used to identify the user currently!)
      "displayName": "John Updated Doe",
      "email": "john.updated.doe@example.com"
    }

## Post Comment Service API

This service manages posts and comments.  It interacts with the User Service to retrieve user information.

**Base URL:** `/v1/posts`

### Endpoints

#### 1. Get Posts by User

*   **Method:** `GET`
*   **Path:** `/`
*   **Description:** Retrieves all posts associated with a specific user.
*   **Parameters:**
    *   `user-id` (query parameter, required): The ID of the user whose posts are to be retrieved.
*   **Response:**
    *   **Success (200 OK):**  Returns a list of `PostDto` objects. If no posts are found for the user, an empty list is returned.
    *   **Error:** If the user does not exist (as determined by the User Service), the API currently returns `null`.  (Consider changing this to a 404 Not Found with a meaningful error message).

    **`PostDto` Structure:**

    ```json
    {
      "id": 123,        // (Long, optional) The unique ID of the post.
      "details": "Post content here.",  // (String) The text content of the post.
      "likes": 5,        // (int) The number of likes the post has.
      "user": {         // (UserDto) Information about the user who created the post.
        "id": 456,      // (long) User ID
        "userName": "john.doe", // (String) User's username
        "displayName": "John Doe", // (String) User's display name
        "email": "john.doe@example.com"  // (String) User's email
      }
    }
    ```

#### 2. Create a Post

*   **Method:** `POST`
*   **Path:** `/`
*   **Description:** Creates a new post for a specified user.
*   **Parameters:**
    *   `user-id` (query parameter, required): The ID of the user creating the post.
*   **Request Body:** A `PostDto` object containing the post details (only the `details` field is required when creating a post, `likes` should be initialized to 0 by the service, and `id` will be assigned by the database). Example:
    ```json
    {
      "details": "This is my new post!"
    }
    ```
*   **Response:**
    *   **Success (200 OK):** Returns the created `PostDto` object, including the assigned ID and user information.
    *   **Error:** If the user does not exist, the API currently returns `null`. (Consider returning a 400 Bad Request or 404 Not Found).

#### 3. Update a Post

*   **Method:** `PATCH`
*   **Path:** `/{post_id}`
*   **Description:** Updates an existing post.
*   **Parameters:**
    *   `post_id` (path parameter, required): The ID of the post to update.
*   **Request Body:** A `PostDto` object with the fields to be updated (currently `details` and `likes`).
    ```json
    {
      "details": "Updated post content.",
      "likes": 10
    }
    ```
*   **Response:**
    *   **Success (200 OK):** Returns the updated `PostDto` object.
    *   **Error:** If the post does not exist, the API currently returns `null`. (Consider returning a 404 Not Found).

## Relation Service API

This service manages relationships between users (e.g., friendships, followers).

**Base URL:** `/v1/relations` (Example - adjust as needed)

### Endpoints (Example - needs actual implementation)

#### 1. Follow User

*   **Method:** `POST`
*   **Path:** `/follow/{follower_id}/{followee_id}`
*   **Description:** Creates a "follows" relationship between two users.
*   **Parameters:**
    *   `follower_id` (path parameter): The ID of the user who is following.
    *   `followee_id` (path parameter): The ID of the user being followed.
*   **Response:**
    *   **Success (201 Created):**  Returns a success message or the created relation object (if applicable).
    *   **Error (400 Bad Request):** If input is invalid or users don't exist.
    *   **Error (409 Conflict):** If the relationship already exists.

#### 2. Unfollow User

*   **Method:** `DELETE`
*   **Path:** `/follow/{follower_id}/{followee_id}`
*   **Description:** Removes a "follows" relationship.
*   **Parameters:** Same as "Follow User".
*   **Response:**
    *   **Success (204 No Content):** Indicates successful deletion.
    *   **Error (404 Not Found):** If the relationship does not exist.

#### 3. Get Followers

*   **Method:** `GET`
*   **Path:** `/followers/{user_id}`
*   **Description:** Retrieves the list of users who follow a given user.
*   **Parameters:**
    *   `user_id` (path parameter): The ID of the user whose followers are being retrieved.
*   **Response:**
    *   **Success (200 OK):** Returns a list of user IDs or user objects (define a suitable DTO if needed).
    *   **Error (404 Not Found):** If the user does not exist.

#### 4. Get Followees (Users Being Followed)

*   **Method:** `GET`
*   **Path:** `/followees/{user_id}`
*   **Description:** Retrieves the list of users a given user is following.
*   **Parameters:** Same as "Get Followers".
*   **Response:** Same structure as "Get Followers".