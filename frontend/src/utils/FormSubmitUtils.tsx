async function submit(url: string, user: { displayName: string; userName: string; email: string; password: string }) {
    const response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
    });

    if (response.ok) {
        const resposeDto = await response.json();
        alert("User created successfully. User id: " + resposeDto.id);
    } else {
        alert("Error creating user");
    }
}

export default submit;
