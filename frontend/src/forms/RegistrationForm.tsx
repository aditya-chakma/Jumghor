import React, { use } from "react";
import type { User } from "../interfaces/User";

interface RegistrationFormProps {
    user: User;
    handleUser: (user: User) => void;
    registerUser: () => void;
}

const RegistrationForm = ({ user, handleUser, registerUser }: RegistrationFormProps) => {
    const handleSubmit = (e) => {
        console.log("Click click!");
        handleUser(user);
        registerUser();
    };

    const handleChange = (e: React.ChangeEvent) => {
        const { id, value } = e.target;
        handleUser({ ...user, [id]: value });
    };

    return (
        <>
            <div style={{ maxWidth: "300px" }}>
                <form onClick={(e) => e.preventDefault()}>
                    <h2 className="text-center font-medium">Create an account</h2>
                    <div className="grid grid-rows-1 gap-2">
                        <div className="flex flex-col">
                            <label htmlFor="userName">User Name</label>
                            <input
                                id="userName"
                                type="text"
                                placeholder="User Name"
                                value={user.userName}
                                onChange={handleChange}
                            />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="displayName">Display Name</label>
                            <input
                                id="displayName"
                                type="text"
                                placeholder="Display name"
                                value={user.displayName}
                                onChange={handleChange}
                            />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="email">Email</label>
                            <input
                                id="email"
                                type="text"
                                placeholder="Email"
                                value={user.email}
                                onChange={handleChange}
                            />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="password">Password</label>
                            <input
                                id="password"
                                type="password"
                                placeholder="Password"
                                value={user.password}
                                onChange={handleChange}
                            />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="confirmPassword">Confirm Password</label>
                            <input
                                id="confirmPassword"
                                type="password"
                                placeholder="Confirm Password"
                                value={user.confirmPassword}
                                onChange={handleChange}
                            />
                        </div>

                        <div className="flex justify-center">
                            <button
                                className="border-2 w-min p-1 rounded-md text-white bg-linear-to-r from-violet-500 to-blue-500"
                                type="submit"
                                onClick={handleSubmit}
                            >
                                Register
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </>
    );
};

export default RegistrationForm;
