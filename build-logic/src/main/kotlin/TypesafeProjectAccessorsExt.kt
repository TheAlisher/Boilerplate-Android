import org.gradle.api.Project

internal val Project.projectsWorkaround: ProjectAccessors
    get() = ProjectAccessors(this)

internal class ProjectAccessors(project: Project) {

    val core = Core(project)

    class Core(private val project: Project) {

        val data get() = project.project(":core:data")
        val domain get() = project.project(":core:domain")
        val presentation get() = project.project(":core:presentation")
    }
}