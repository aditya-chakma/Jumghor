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
            <div className="container mx-auto px-4">
                <form onSubmit={handleSubmit}>
                    <label htmlFor="display-name">Display Name: </label>
                    <input
                        className="input-default"
                        id="display-name"
                        name="display-name"
                        type="text"
                        value={user.displayName}
                        onChange={(e) => setUser({ ...user, displayName: e.target.value })}
                    ></input>
                    <br />

                    <label htmlFor="user-name">User Name: </label>
                    <input
                        id="user-name"
                        name="user-name"
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
            </div>
        </>
    );
};

export default RegisterUser;
