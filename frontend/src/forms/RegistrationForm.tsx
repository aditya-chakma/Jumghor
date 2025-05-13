const RegistrationForm = () => {
    const handleSubmit = (e) => {
        console.log("Click click!");
    };

    return (
        <>
            <div style={{ maxWidth: "300px" }}>
                <form onClick={(e) => e.preventDefault()}>
                    <h2 className="text-center font-medium">Create an account</h2>
                    <div className="grid grid-rows-1 gap-2">
                        <div className="flex flex-col">
                            <label htmlFor="user-name">User Name</label>
                            <input id="user-name" type="text" placeholder="User Name" />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="display-name">Display Name</label>
                            <input id="display-name" type="text" placeholder="Display name" />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="email">Email</label>
                            <input id="email" type="text" placeholder="Email" />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="password">Password</label>
                            <input id="password" type="password" placeholder="Password" />
                        </div>

                        <div className="flex flex-col">
                            <label htmlFor="confirm-password">Confirm Password</label>
                            <input id="confirm-password" type="password" placeholder="Confirm Password" />
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
