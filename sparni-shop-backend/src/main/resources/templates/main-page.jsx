
import "../components/Skills.scss";

function Skills() {
  return (
    <section className="skills-grid" id="skills">
      <div className="container">
      <p className="note"># Here are the skills I've developed through my journey.</p><br/>
        
        <div className="skills-category">
          <h3>Programming languages</h3>
          <table>
            <tbody>
              <tr>
                <td className="redish">Java</td>
                <td className="redish">Medium</td>
              </tr>

            </tbody>
          </table>
        </div>     
      </div>
    </section>
  );
}

export default Skills;