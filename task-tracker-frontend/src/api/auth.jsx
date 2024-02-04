const signUpApi = async (data) => {
    const response = await fetch(`${URL}/signup`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.json();
};

const signInApi = async (data) => {
    const response = await fetch(`${URL}/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    localStorage.setItem("token", response.token);
    localStorage.setItem("user", response.user?.id);
    return response.json();
};

const signOutApi = () => {
    localStorage.removeItem("token");
}