# Android Toolbox

Lab, playground, or anything that's related to Android development.



### Goals

1. Completely Kotlin-based
   I love Kotlin - so I'm gonna use Kotlin everywhere.
   Some of them are:
   - **Koin** for DI instead of Dagger2 because there're tons of boilerplate in Dagger2 - it's not elegant.
   - **Gradle Kotlin DSL** for Gradle instead of groovy because dynamic programming language sucks.
   - **kotlintest** for Testing instead of JUnit, because JUnit sucks when in comes to Kotlin.
2. Declarative
   Seems like everybody tends to be "declarative", so I decided to be declarative too.
3. Deploy-able
   Recently I learned how to deploy my own stuff. I'm gonna be cool soon. 😎



### Module structure

- build-tools
  All build configurations and logics stands here. Head over to [here](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources) to get more info.

  > There are other option: `buildSrc`. But there's some reason that I didn't use it.
  >
  > 1. Some limitations when editing. For example, tests are not properly executed in IDE. When you sync gradle, buildSrc is automatically be built, and you should manually open the build reports to get the test result.
  > 2. To try "composite build" in Gradle. It's relatively new concept, and it might be useful in some cases.

- libs
  Collection of reusable gradle modules. It can be anything - pure kotlin library, or Android-specific libraries

- lab
  Where I test modules
