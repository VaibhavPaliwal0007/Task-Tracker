import Head from 'next/head';

export default function CreateTask() {
  const styles = {
    container: {
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      height: '100vh',
      // backgroundColor: '#e0e5ec', // Light background for contrast
    },
    form: {
      display: 'flex',
      flexDirection: 'column',
      gap: '20px',
      padding: '40px',
      background: 'rgba(255, 255, 255, 0.7)',
      backdropFilter: 'blur(10px)',
      borderRadius: '20px',
      border: '1px solid rgba(255, 255, 255, 0.3)',
      boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
      maxWidth: '400px',
      width: '100%',
    },
    input: {
      padding: '10px',
      margin: '10px 0',
      border: 'none',
      borderRadius: '10px',
      background: 'rgba(255, 255, 255, 0.5)',
      backdropFilter: 'blur(5px)',
    },
    textarea: {
      padding: '10px',
      margin: '10px 0',
      border: 'none',
      borderRadius: '10px',
      background: 'rgba(255, 255, 255, 0.5)',
      backdropFilter: 'blur(5px)',
      height: '100px',
    },
    button: {
      padding: '10px',
      border: 'none',
      borderRadius: '10px',
      cursor: 'pointer',
      background: 'linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%)',
      color: 'white',
    },
    title: {
      textAlign: 'center',
    },
  };

return (
    <div style={styles.container}>
      <Head>
        <title>Create Task</title>
      </Head>
      <form style={styles.form}>
        <h1 style={styles.title}>Create a New Task</h1>
        <input
          style={styles.input}
          type="text"
          placeholder="Task Title"
          required
        />
        <textarea
          style={styles.textarea}
          placeholder="Task Description"
          required
        ></textarea>
        <input
          style={styles.input}
          type="date"
          placeholder="Due Date"
          required
        />
        <button type="submit" style={styles.button}>Create Task</button>
      </form>
    </div>
  );
}
