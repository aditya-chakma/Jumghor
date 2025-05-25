import React, { useState } from "react";
import type { LoginCredentials } from "../interfaces/LoginCredentials";

interface LoginFormProps {
    onCreateAccount: () => void;
}

const LoginForm = ({ onCreateAccount }: LoginFormProps) => {
    const [credentials, setCredentials] = useState<LoginCredentials>({
        userName: "",
        password: ""
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { id, value } = e.target;
        setCredentials(prev => ({ ...prev, [id]: value }));
    };

    const handleLogin = (e: React.FormEvent) => {
        e.preventDefault();
        // TODO: Implement login logic
        console.log("Login attempted with:", credentials);
    };

    return (
        <div className="w-full max-w-md p-6 bg-white rounded-lg shadow-md">
            <form onSubmit={handleLogin}>
                <h2 className="text-2xl font-bold text-center mb-6">Login</h2>
                <div className="space-y-4">
                    <div>
                        <label htmlFor="userName" className="block text-sm font-medium text-gray-700">
                            Username
                        </label>
                        <input
                            id="userName"
                            type="text"
                            value={credentials.userName}
                            onChange={handleChange}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                            required
                        />
                    </div>
                    <div>
                        <label htmlFor="password" className="block text-sm font-medium text-gray-700">
                            Password
                        </label>
                        <input
                            id="password"
                            type="password"
                            value={credentials.password}
                            onChange={handleChange}
                            className="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
                            required
                        />
                    </div>
                    <button
                        type="submit"
                        className="w-full py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 cursor-pointer"
                    >
                        Login
                    </button>
                    <div className="text-center mt-4">
                        <button
                            type="button"
                            onClick={onCreateAccount}
                            className="text-indigo-600 hover:text-indigo-500 cursor-pointer"
                        >
                            Create new account
                        </button>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default LoginForm; 