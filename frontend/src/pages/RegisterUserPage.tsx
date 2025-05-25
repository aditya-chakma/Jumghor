import { useState } from "react";
import submit from "../utils/RequestUtils";
import RegistrationForm from "../forms/RegistrationForm";
import LoginForm from "../forms/LoginForm";
import Modal from "../components/Modal";
import ImageCarousel from "../components/ImageCarousel";
import type { User } from "../interfaces/User";

const RegisterUserPage = () => {
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [user, setUser] = useState<User>({
        userName: "",
        displayName: "",
        email: "",
        password: "",
        confirmPassword: "",
    });

    const registerUser = async () => {
        await submit("http://localhost:8100/v1/u/profile", user);
        setIsModalOpen(false);
    };

    const handleUser = (u: User) => {
        setUser(u);
    };

    return (
        <main className="min-h-screen bg-gray-50 flex items-center justify-center">
            <div className="w-full max-w-6xl flex flex-row max-sm:flex-col justify-center items-center gap-8 p-8">
                <div className="w-full max-w-lg h-[600px] bg-gray-100 rounded-lg overflow-hidden shadow-xl">
                    <ImageCarousel />
                </div>
                
                <div className="w-full max-w-md">
                    <LoginForm onCreateAccount={() => setIsModalOpen(true)} />
                </div>
            </div>

            <Modal
                isOpen={isModalOpen}
                onClose={() => setIsModalOpen(false)}
                title="Create New Account"
            >
                <RegistrationForm
                    handleUser={handleUser}
                    user={user}
                    registerUser={registerUser}
                />
            </Modal>
        </main>
    );
};

export default RegisterUserPage;
