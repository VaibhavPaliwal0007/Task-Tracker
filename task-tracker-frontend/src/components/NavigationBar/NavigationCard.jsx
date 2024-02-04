import { useState } from "react";

const NavigationBar = ({setView}) => {
  // Inline CSS styles for glassmorphism and aesthetics
  const styles = {
    navContainer: {
      display: 'flex',
      flexDirection: 'column',
      justifyContent: 'flex-start',
      alignItems: 'flex-start',
      minHeight: '100vh',
      padding: '20px',
      background: 'rgba(255, 255, 255, 0.75)',
      backdropFilter: 'blur(10px)',
      borderRadius: '10px',
      boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
      color: '#333',
      width: '250px',
      position: 'fixed',
      top: '0',
      left: '0',
      bottom: '0',
    },
    navTitle: {
      margin: '0 0 20px 0',
      fontWeight: 'bold',
      fontSize: '24px',
      color: '#333',
    },
    navLink: {
      margin: '10px 0',
      textDecoration: 'none',
      color: '#333',
      fontWeight: 'bold',
      fontSize: '18px',
      transition: 'color 0.3s',
    },
    navLinkActive: {
      color: '#4CAF50', // Highlight color for active link
    }
  };

  

  return (
    <nav style={styles.navContainer}>
      <div style={styles.navTitle}>TASK TRACKER</div>
        <button style={styles.navLink} onClick={() => setView('all')}>All Tasks</button>
        <button style={styles.navLink} onClick={() => setView('create')}>Create Task</button>
    </nav>
  );
};

export default NavigationBar;