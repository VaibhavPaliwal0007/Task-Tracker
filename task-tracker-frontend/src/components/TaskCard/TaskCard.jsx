import { useState } from "react";

export default function TaskCard(props) {
  const { task } = props;
  const { id, title, description, status } = task;

  const cardStyles = {
    card: {
      width: "300px",
      padding: "20px",
      background: "rgba(255, 255, 255, 0.7)",
      backdropFilter: "blur(10px)",
      borderRadius: "15px",
      border: "1px solid rgba(255, 255, 255, 0.3)",
      boxShadow: "0 4px 6px rgba(0, 0, 0, 0.1)",
      fontFamily: "'Segoe UI', Tahoma, Geneva, Verdana, sans-serif",
      color: "#333",
      margin: "20px",
    },
    cardHeader: {
      display: "flex",
      justifyContent: "space-between",
      alignItems: "center",
    },
    cardTitle: {
      margin: "0",
      fontSize: "20px",
      color: "#333",
    },
    cardActions: {
      display: "flex",
      gap: "10px",
    },
    btn: {
      padding: "10px 15px",
      border: "none",
      borderRadius: "8px",
      cursor: "pointer",
      fontSize: "14px",
      transition: "background-color 0.3s, transform 0.2s",
    },
    edit: {
      backgroundColor: "#4CAF50", // Green
      color: "white",
      ":hover": {
        backgroundColor: "#45a049",
      },
    },
    delete: {
      backgroundColor: "#f44336", 
      color: "white",
      ":hover": {
        backgroundColor: "#da190b",
      },
    },
    cardDescription: {
      marginTop: "20px",
    },
    dueDate: {

      fontSize: "14px",
      color: "#555",
      fontStyle: "italic",
    },
    toggleLabel: {
      display: 'flex',
      alignItems: 'center',
      cursor: 'pointer',
      fontWeight: 'normal',
      fontSize: '14px',
      color: '#333',
      gap: '10px',
    },
    toggleInput: {
      opacity: 0,
      width: 0,
      height: 0,
    },
    toggleSlider: {
      position: 'relative',
      display: 'inline-block',
      width: '40px',
      height: '20px',
      background: '#ccc',
      borderRadius: '20px',
      ':before': {
        content: '""',
        position: 'absolute',
        left: '2px',
        bottom: '2px',
        width: '16px',
        height: '16px',
        background: 'white',
        borderRadius: '50%',
        transition: '0.4s',
      },
    },
    toggleChecked: {
      background: '#4CAF50',
    },
    toggleButtonBefore: {
      transform: 'translateX(20px)',
    },
  };

  const [isEditing, setIsEditing] = useState(false);
  const [editTitle, setEditTitle] = useState(title);
  const [editDescription, setEditDescription] = useState(description);
  const [editDueDate, setEditDueDate] = useState('');

  const [isCompleted, setIsCompleted] = useState(false);

  const handleEdit = () => {
    setIsEditing(false);
  };

  const toggleSliderStyle = {
    ...cardStyles.toggleSlider,
    background: isCompleted ? '#4CAF50' : '#ccc',
  };

  const toggleBeforeStyle = {
    content: '""',
    position: 'absolute',
    left: '2px',
    bottom: '2px',
    width: '16px',
    height: '16px',
    background: 'white',
    borderRadius: '50%',
    transition: '0.4s',
    transform: isCompleted ? 'translateX(20px)' : 'translateX(0)',
  };

  return (
  <div style={cardStyles.card}>
      <div style={cardStyles.cardHeader}>
        {isEditing ? (
          <input
            type="text"
            value={editTitle}
            onChange={(e) => setEditTitle(e.target.value)}
            style={cardStyles.input}
          />
        ) : (
          <h2 style={cardStyles.cardTitle}>{title}</h2>
        )}
        <div style={cardStyles.cardActions}>
          {isEditing ? (
            <button style={{...cardStyles.btn, ...cardStyles.edit}} onClick={handleEdit}>Save</button>
          ) : (
            <>
              <button style={{...cardStyles.btn, ...cardStyles.edit}} onClick={() => setIsEditing(true)}>Edit</button>
              <button style={{...cardStyles.btn, ...cardStyles.delete}}>Delete</button>
            </>
          )}
        </div>
      </div>
      {isEditing ? (
        <>
          <textarea
            value={editDescription}
            onChange={(e) => setEditDescription(e.target.value)}
            style={cardStyles.textarea}
          />
          <input
            type="date"
            value={editDueDate}
            onChange={(e) => setEditDueDate(e.target.value)}
            style={cardStyles.input}
          />
        </>
      ) : (
        <p style={cardStyles.cardDescription}>{description}</p>
      )}
      <div style={cardStyles.dueDate}>Due Date: 2024-02-10</div>
       <label style={cardStyles.toggleLabel}>
         Mark as Completed
         <input
          type="checkbox"
          style={cardStyles.toggleInput}
          checked={isCompleted}
          onChange={() => setIsCompleted(!isCompleted)}
        />
        <span style={toggleSliderStyle}>
          <span style={toggleBeforeStyle}></span>
        </span>
      </label>
    </div>
  );

}
