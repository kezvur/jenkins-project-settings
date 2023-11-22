job('First-Maven-Project-Via-DSL') {
    description("First Maven job generated by the DSL on ${new Date()}, the project is a small Maven project hosted on github")
    scm {
        git("https://github.com/RFaqiri/java-tomcat-sample-main.git", 'main')
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        maven{
            goals('clean package')
            rootPOM('pom.xml')
            mavenInstallation('maven-3.9.5')
        }
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.war'
    }
}
