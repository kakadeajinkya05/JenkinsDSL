job('Master Build and Test') {
    scm {
        git {
            remote {
                url ' https://ositechportal@bitbucket.org/ositechportal/osi-recruitment-portal.git'
				
            }
            extensions {
                wipeOutWorkspace()
            }
            branch '*/MD_MASTER*'
	    scanCredentialsId('bbid')
        }
    }

    steps {
        gradle {
            tasks('clean')
            tasks('test')
            switches('-i')
            useWrapper()
        }
    }

    triggers {
        scm('* * * * *') {
            ignorePostCommitHooks()
        }
    }


    wrappers {
        colorizeOutput()
	    credentialsBinding {
            usernamePassword('MY_USERNAME','MY_PASSWORD')
        }
    }
}
