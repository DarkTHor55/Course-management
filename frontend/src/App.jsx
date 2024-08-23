import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CreateCoursePage from './CreateCourse/CreateCoursePage';
import CoursesPage from './MainPage/CoursesPage';
import Navbar from './CreateCourse/Navbar';
import SearchCourse from './search/SearchCourse';
import AllCourses from './AllCourses/AllCourses';
import CreateInstance from './CreateInstance/CreateInstance';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/create-course" element={<><CreateCoursePage/> </>} />
        <Route path="/home" element={<><CoursesPage/> </>} />
        <Route path="/search" element={<><SearchCourse/> </>} />
        <Route path="/courses" element={<><AllCourses/> </>} />
        <Route path="/create-instance" element={<><CreateInstance/> </>} />
      </Routes>
    </Router>
  );
}

export default App;
