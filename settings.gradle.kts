fun includeProject(name: String, projectPath: String? = null) {
    include(name)
    projectPath?.run { project(name).projectDir = File(this) }
}

includeBuild("build-tools")
includeBuild("build-tools-internal")

includeProject(":lab")

includeProject(":core", "libs/core")
includeProject(":databinding", "libs/databinding")
includeProject(":lifecycle", "libs/lifecycle")
includeProject(":animation", "libs/animation")
