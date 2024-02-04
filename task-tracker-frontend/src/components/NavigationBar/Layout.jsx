import NavigationCard from './NavigationCard';

const Layout = ({ children , setView }) => {
  const styles = {
    container: {
      display: 'flex',
      minHeight: '100vh',
    },
    content: {
      flexGrow: 1,
      padding: '20px',
    },
  };

  return (
    <div style={styles.container}>
      <NavigationCard  setView = {setView}/>
      <main style={styles.content}>{children}</main>
    </div>
  );
};

export default Layout;