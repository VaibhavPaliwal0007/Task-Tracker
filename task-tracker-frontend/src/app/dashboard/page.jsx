'use client';

import TaskCard from "@/components/TaskCard";
import { getTasks } from "@/api/task";
import { useState, useEffect } from "react";

export default function Dashboard() {
    const [modalState, setModalState] = useState(false);

    const openModalHandler = () => {
        setModalState(true);
    };

    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const tasksData = await getTasks();
                setTasks(tasksData);
            } catch (error) {
                console.error("Error fetching tasks:", error);
            }
        };
        fetchData();
    }, []);

    return (
        <>
            <div className="flex">
                <h1>Task Tracker</h1>
                <button onClick={openModalHandler}>Add Task</button>
            </div>

            <div>
                {tasks.map((task) => (
                    <TaskCard key={task.id} task={task} />
                ))}
            </div>
        </>
    );
}
