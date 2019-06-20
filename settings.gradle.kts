fun includeProject(name: String, projectPath: String? = null) {
    include(name)
    projectPath?.run { project(name).projectDir = File(this) }
}

includeBuild("build-tools")
includeProject(":lab")
includeProject(":databinding", "libs/databinding")
includeProject(":lifecycle", "libs/lifecycle")
