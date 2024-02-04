import React, { useState } from "react";
import { addTask } from "@/api/task";

export default function TaskModal() {
    const addTaskHandler = () => {};

    return (
        <div
            className={`${
                modalOpen ? "" : "opacity-0 pointer-events-none"
            } duration-300 fixed h-screen w-screen top-0 left-0 text-slate-800 bg-slate-900/50 backdrop-blur-sm z-30 grid place-items-center`}
        >
            <div className="card shadow-lg bg-white p-4 rounded-lg w-full md:w-96">
                <h1 className="font-bold uppercase text-xl mb-4 flex justify-between">
                    <span>Edit Task</span>
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        strokeWidth={1.5}
                        stroke="currentColor"
                        className="w-6 h-6 hover:scale-105 active:scale-95 hover:text-blue-700 duration-150"
                    >
                        <path
                            strokeLinecap="round"
                            strokeLinejoin="round"
                            d="m9.75 9.75 4.5 4.5m0-4.5-4.5 4.5M21 12a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z"
                        />
                    </svg>
                </h1>
                <div className="flex flex-col gap-4">
                    <div>
                        <h2 className="pb-2">Input Label</h2>
                        <input
                            type="text"
                            placeholder={"Placeholder"}
                            className={`focus:border-b-blue-500 w-full p-2 md:p-3 text-sm bg-slate-200 focus:bg-background2 outline-none border-2 rounded-lg focus:rounded-none focus:rounded-t-lg  transition-all duration-500`}
                        />
                    </div>
                    <button
                        onClick={addTaskHandler}
                        className="bg-blue-500 w-full text-slate-50 p-2 rounded-md hover:scale-105 active:scale-95 duration-300"
                    >
                        SAVE
                    </button>
                </div>
            </div>
        </div>
    );
}
