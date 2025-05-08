import { useState } from "react";
import submit from "../utils/FormSubmitUtils";

const RegisterUser = () => {
    const [user, setUser] = useState({
        displayName: "",
        userName: "",
        email: "",
        password: "",
    });

    const registerUser = async () => {
        submit("http://localhost:8100/v1/u/profile", user);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        registerUser();
    };

    return (
        <>
            <form onSubmit={handleSubmit}>
                <label htmlFor="displayName">Display Name: </label>
                <input
                    id="displayName"
                    name="displayName"
                    type="text"
                    value={user.displayName}
                    onChange={(e) => setUser({ ...user, displayName: e.target.value })}
                ></input>
                <br />

                <label htmlFor="userName">User Name: </label>
                <input
                    id="userName"
                    name="userName"
                    type="text"
                    value={user.userName}
                    onChange={(e) => setUser({ ...user, userName: e.target.value })}
                ></input>
                <br />

                <label htmlFor="email">Email: </label>
                <input
                    id="email"
                    name="email"
                    type="email"
                    value={user.email}
                    onChange={(e) => setUser({ ...user, email: e.target.value })}
                ></input>
                <br />

                <label htmlFor="password">Password: </label>
                <input
                    id="password"
                    name="password"
                    type="password"
                    value={user.password}
                    onChange={(e) => setUser({ ...user, password: e.target.value })}
                ></input>
                <br />

                <button type="submit">Register</button>
            </form>
        </>
    );
};

export default RegisterUser;
