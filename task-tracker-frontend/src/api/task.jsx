const getTasks = async () => {
    const response = await fetch(`${URL}/all`, {
        headers: {
            "Authorization": `Bearer ${localStorage.getItem("token")}`,
        },
    });
    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

const addTask = async (task) => {
    const response = await fetch(`${URL}/create`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${localStorage.getItem("token")}`,
            "X-USER-ID": localStorage.getItem("user"),
        },
        body: JSON.stringify(task),
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

const deleteTask = async (taskId) => {
    const response = await fetch(`${URL}/${taskId}`, {
        method: "DELETE",
        "X-USER-ID": localStorage.getItem("user"),
        "Authorization": `Bearer ${localStorage.getItem("token")}`,
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

const updateTask = async (id, task) => {
    const response = await fetch(`${URL}/update`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
            "X-USER-ID": localStorage.getItem("user"),
            "Authorization": `Bearer ${localStorage.getItem("token")}`,
        },
        body: JSON.stringify(task),
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

export { getTasks, addTask, deleteTask, updateTask };
