Simple Frontend development Showcase
-----

# Setup

Install [parceljs](https://parceljs.org/getting_started.html) tooling via:
```
npm install -g parcel-bundler
```

Init project via:
```
npm init -y
```
This creates a package.json file with some project metadata, 
like projectname, projectversion, license, used libraries and frameworks, etc.

## Live Reload
ParcelJS supports automatic reloading of browser contents after 
code changes without the need to manually refresh the browser.

Just install the live-reload extension for Chrome or Firefox from:
http://livereload.com/extensions/

# Running

Start the local dev-server via:
```
npm run start
```

Browse to http://localhost:1234

Play around with the source code in the `src/` directory.

# Building

Run the following command to build a distributable version of your code:
```
npm run build
```

Then copy the contents of the `dist` folder to a webserver.