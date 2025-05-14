const UserDetails = () => {
    return (
        <>
            <div className="text-center text-4xl mb-4">User Profile</div>
            <div className="flex justify-around mb-3">
                <div className="flex justify-center flex-col gap-3">
                    <div className="grid grid-cols-1">
                        <span>Aditya Larma</span>
                        <span className="text-sm">User Name</span>
                    </div>
                    <div className="grid grid-cols-1">
                        <span>adityachakma199@gmail.com</span>
                        <span className="text-sm">Email</span>
                    </div>
                </div>
                <div>
                    <div className="flex items-center justify-center size-40 rounded-full bg-conic/decreasing from-violet-700 via-lime-300 to-violet-700">
                        Profile picture
                    </div>
                </div>
            </div>
        </>
    );
};

export default UserDetails;
