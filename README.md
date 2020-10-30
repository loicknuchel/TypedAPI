# TypedAPI [![travis-badge][]][travis] [![codecov-badge][]][codecov] [![release-badge][]][release] [![maven-badge][]][maven] [![license-badge][]][license]

[travis]:                          https://travis-ci.com/loicknuchel/TypedAPI
[travis-badge]:                    https://travis-ci.com/loicknuchel/TypedAPI.svg?branch=master
[codecov]:                      http://codecov.io/github/loicknuchel/TypedAPI?branch=master
[codecov-badge]:                http://codecov.io/github/loicknuchel/TypedAPI/coverage.svg?branch=master
[release]:                            https://github.com/loicknuchel/TypedAPI/releases/latest
[release-badge]:   https://img.shields.io/github/release/loicknuchel/TypedAPI.svg
[maven]:            https://search.maven.org/artifact/fr.loicknuchel/typedapi_2.13
[maven-badge]: https://img.shields.io/maven-central/v/fr.loicknuchel/typedapi_2.13
[license]:                            https://github.com/loicknuchel/TypedAPI/blob/master/LICENSE
[license-badge]:   https://img.shields.io/github/license/loicknuchel/TypedAPI

A Scala OpenAPI parser, validator, and generator.

## Quick Start

Add the dependency to your `build.sbt` (Scala 2.12 or later):

```scala
libraryDependencies += "fr.loicknuchel" %% "typedapi" % "<version>"
```

## Releasing

Every commit on master is [released as SNAPSHOT](https://oss.sonatype.org/#nexus-search;quick~fr.loicknuchel) so you can use it immediately thanks to [sbt-ci-release](https://github.com/olafurpg/sbt-ci-release) plugin.
To push a stable release, push a tag version starting with 'v' (ex: `v0.1.0`) or create a release from github interface with a correct tage name.
