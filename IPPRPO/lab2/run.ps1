param([ValidateSet('run','test','build')][string]$Action='run')
$ErrorActionPreference='Stop'
$jdk=$env:JAVA_HOME
if (-not $jdk) { $jdk='D:\IntelliJ IDEA 2026.2.3\jbr' }
Push-Location (Join-Path $PSScriptRoot 'project')
try {
    New-Item -ItemType Directory out -Force | Out-Null
    $sources=@(Get-ChildItem src,tests -Filter '*.java' | ForEach-Object FullName)
    & (Join-Path $jdk 'bin\javac.exe') -encoding UTF-8 --release 17 -d out @sources
    if ($LASTEXITCODE -ne 0) { throw 'Ошибка компиляции.' }
    if ($Action -ne 'build') {
        $main=if ($Action -eq 'test') { 'SmokeTest' } else { 'Main' }
        & (Join-Path $jdk 'bin\java.exe') '-Dfile.encoding=UTF-8' '-Dstdout.encoding=UTF-8' -cp out $main
        if ($LASTEXITCODE -ne 0) { throw 'Ошибка запуска.' }
    }
} finally { Pop-Location }
