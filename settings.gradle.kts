fun includeProject(name: String, projectPath: String? = null) {
    include(name)
    projectPath?.run { project(name).projectDir = File(this) }
}

includeBuild("build-tools")

includeProject(":lab")

includeProject(":base-app", "libs/base-app")
includeProject(":base-app-rx", "libs/base-app-rx")
includeProject(":core", "libs/core")
includeProject(":databinding", "libs/databinding")
includeProject(":lifecycle", "libs/lifecycle")
includeProject(":animation", "libs/animation")
