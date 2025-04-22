import { useEffect, useState } from "react";

function User() {
    const [userList, setUserList] = useState([]);

    useEffect(() => {
        fetch("/u/all")
            .then((response) => response.arrayBuffer())
            .then((data) => setUserList(data))
            .catch((error) => console.error("Error fetching userlist: ", error));
    }, []);
}

export default User;
