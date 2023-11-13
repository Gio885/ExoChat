import './App.css';
import Home from './Component/Home';
import { HOME } from './utility/Route';

function App() {
  return (
    <>
    <BrowserRouter>
    
      <Switch>

        <Route exact path = {HOME}>
            <Home/>

        </Route>



      </Switch>
    
    
    
    
    </BrowserRouter>
    
    
    </>
  
  );
}

export default App;
