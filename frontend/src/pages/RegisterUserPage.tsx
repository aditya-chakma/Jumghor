import { useState } from "react";
import submit from "../utils/RequestUtils";
import RegistrationForm from "../forms/RegistrationForm";
import type { User } from "../interfaces/User";

const RegisterUserPage = () => {
    const [user, setUser] = useState<User>({
        userName: "",
        displayName: "",
        email: "",
        password: "",
        confirmPassword: "",
    });

    const registerUser = async () => {
        submit("http://localhost:8100/v1/u/profile", user);
    };

    const handleSubmit = () => {
        registerUser();
    };

    const handleUser = (u: User) => {
        setUser(u);
    };

    return (
        <>
            <main>
                <div className="flex flex-row max-sm:flex-col justify-around m-16 mt-0 mb-0">
                    <div
                        className="flex flex-col justify-center gap-3 p-3 m-3"
                        style={{ minWidth: "300px", minHeight: "300px", background: "skyblue" }}
                    >
                        <p className="text-center text-3xl">Your data, your right. Privacy Matters.</p>
                        <p className="text-center text-3xl">Not another Facebook or X</p>
                        <p className="text-center text-3xl">Join Now </p>
                    </div>
                    <div>
                        <RegistrationForm handleUser={handleUser} user={user} registerUser={handleSubmit} />
                    </div>
                </div>
            </main>
        </>
    );
};

export default RegisterUserPage;
