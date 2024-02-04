const getTasks = async () => {
    const response = await fetch(URL);
    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

const addTask = async (task) => {
    const response = await fetch(URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(task),
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

const deleteTask = async (id) => {
    const response = await fetch(`${URL}/${id}`, {
        method: "DELETE",
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

const updateTask = async (id, task) => {
    const response = await fetch(`${URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(task),
    });

    if (!response.ok) {
        throw new Error("Something went wrong");
    }

    return response.data;
};

export { getTasks, addTask, deleteTask, updateTask };
