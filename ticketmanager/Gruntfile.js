module.exports = function(grunt) {
	
	// Do grunt-related things in here
	grunt.initConfig({
		pkg: grunt.file.readJSON('package.json'),
		jshint: {
			// define the files to lint
			files: ['Gruntfile.js', 'src/**/*.js'],
			// configure JSHint (documented at http://www.jshint.com/docs/)
			options: {
				// more options here if you want to override JSHint defaults
				globals: {
					jQuery: true,
					console: true,
					module: true
				}
			}
		},
		copy: {
			dev: {
				files: [{src: 'bower_components/jquery/jquery.js', dest: 'src/main/webapp/js/jquery/jquery.js'}]
			},
			prod: {
				files: [{src: 'bower_components/jquery/jquery.min.js', dest: 'src/main/webapp/js/jquery.js'}]				
			}
		}
	});
	
	// Load the plugin that provides the "uglify" task.
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-copy');
	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-contrib-watch');
	grunt.loadNpmTasks('grunt-contrib-concat');
	
	// Default task(s).
	grunt.registerTask('default', ['copy:dev', 'jshint']);
	
};