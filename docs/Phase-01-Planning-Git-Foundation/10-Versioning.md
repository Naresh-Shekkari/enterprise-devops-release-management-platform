# Versioning Strategy

**Project:** Enterprise DevOps Release Management Platform (ERMP)

**Company:** ABC Bank Pvt Ltd

**Version:** 1.0

**Author:** Naresh Shekkari

---

# 1. Objective

The purpose of this document is to define the versioning strategy followed in the Enterprise DevOps Release Management Platform (ERMP).

Versioning helps teams:

- Track releases
- Manage deployments
- Rollback safely
- Identify bugs quickly
- Maintain compatibility
- Automate CI/CD pipelines

Every component in our project follows a versioning standard.

---

# 2. What is Versioning?

Versioning is the process of assigning a unique version number to every release of software.

Instead of saying:

"Deploy the latest application"

we say

"Deploy version v2.3.1"

This avoids confusion and enables traceability.

---

# 3. Why Versioning is Important

Without versioning:

❌ Difficult to identify deployed software

❌ Rollback becomes difficult

❌ Docker images overwrite each other

❌ Production incidents become harder to troubleshoot

❌ No release history

Versioning provides:

- Traceability
- Stability
- Easy Rollback
- Automation
- Auditability

---

# 4. Semantic Versioning (SemVer)

Our project follows Semantic Versioning.

Format:

MAJOR.MINOR.PATCH

Example:

1.0.0

Meaning:

MAJOR = Breaking Changes

MINOR = New Features

PATCH = Bug Fixes

Example:

| Version | Description |
|----------|-------------|
|1.0.0|Initial Release|
|1.0.1|Bug Fix|
|1.1.0|New Feature|
|2.0.0|Major Breaking Change|

---

# 5. Version Lifecycle

```

Development

↓

Testing

↓

Release Candidate

↓

Production

↓

Maintenance

```

Example

v1.0.0-dev

↓

v1.0.0-rc1

↓

v1.0.0

↓

v1.0.1

---

# 6. Release Types

Major Release

Example

2.0.0

Changes:

- Database redesign
- API changes
- Breaking compatibility

---

Minor Release

Example

2.1.0

Changes:

- New Payment Module
- Dashboard Improvements
- Notification Service

---

Patch Release

Example

2.1.3

Changes:

- Login Bug
- Memory Leak Fix
- Security Patch

---

# 7. Git Tag Strategy

Every production deployment is tagged.

Examples:

v1.0.0

v1.0.1

v1.1.0

v2.0.0

Command

git tag v1.0.0

git push origin v1.0.0

Benefits:

- Easy rollback
- Release tracking
- Deployment history

---

# 8. Branch vs Version

| Branch | Version |
|----------|----------|
|feature/login|No Version|
|develop|Development|
|release/v2.0|Release Candidate|
|main|Production Version|

---

# 9. Docker Image Versioning

Every Docker image is versioned.

Example:

banking-app:v1.0.0

banking-app:v1.0.1

banking-app:v1.1.0

banking-app:v2.0.0

Never deploy only:

latest

Instead use:

banking-app:v2.3.1

---

# 10. Kubernetes Versioning

Deployment YAML

image:

banking-app:v2.1.0

Upgrade

v2.1.0

↓

v2.2.0

↓

Rolling Update

↓

Pods Updated

---

# 11. Terraform Versioning

Terraform modules also follow versioning.

Example

network-module

v1.0.0

↓

v1.1.0

↓

v2.0.0

Each module is version controlled using Git tags.

---

# 12. Ansible Versioning

Playbooks are version controlled through Git.

Example

playbook

↓

Git Tag

↓

Release

Roles

Version

v1.0

v1.1

v2.0

---

# 13. Jenkins Versioning

Pipeline versions are stored in Git.

Jenkinsfile

↓

Git Commit

↓

Version

This enables rollback of pipeline changes.

---

# 14. Kubernetes Upgrade Example

Current

v2.0.0

Developer pushes

v2.1.0

↓

Docker Build

↓

Amazon ECR

↓

Kubernetes Rolling Update

↓

Health Check

↓

Success

Old Pods Removed

---

# 15. Rollback Strategy

Suppose

v2.1.0 fails.

Rollback

```

Current

↓

v2.1.0

↓

Rollback

↓

v2.0.5

↓

Production Stable

```

Rollback can be done using:

Git Tag

Docker Image

Kubernetes Rollout

---

# 16. Release Candidate (RC)

Before production,

Release Candidate is created.

Example

v2.0.0-rc1

↓

Testing

↓

v2.0.0-rc2

↓

Production

↓

v2.0.0

---

# 17. Build Number

Jenkins creates unique build numbers.

Example

Build #102

↓

Version

v2.1.0

↓

Docker Image

banking-app:v2.1.0-build102

Benefits:

- Easier debugging
- Faster rollback
- Build traceability

---

# 18. Release Notes

Every release includes:

Release Version

Release Date

Features

Bug Fixes

Known Issues

Rollback Plan

Deployment Window

Example:

Release: v2.1.0

Features:

- QR Payments
- Notification Service

Bug Fixes:

- Login timeout

---

# 19. Production Deployment Flow

Developer

↓

Git Commit

↓

Git Tag

↓

GitHub

↓

Webhook

↓

Jenkins

↓

Docker Build

↓

Docker Tag

↓

Push to Amazon ECR

↓

Deploy to Amazon EKS

↓

Rolling Update

↓

Production

---

# 20. Best Practices

- Follow Semantic Versioning.
- Tag every production release.
- Never overwrite Docker image versions.
- Avoid using "latest" in production.
- Store release notes.
- Version Terraform modules.
- Version Ansible playbooks.
- Keep rollback artifacts.
- Maintain release history.

---

# 21. Common Mistakes

❌ Deploying "latest" Docker image.

❌ No Git Tags.

❌ Skipping release notes.

❌ Inconsistent version numbers.

❌ Manual version tracking.

❌ Overwriting previous images.

❌ No rollback version.

---

# 22. Real Production Scenario

ABC Bank introduces UPI Lite.

Current Version:

v3.1.0

Developer completes feature.

↓

Release Branch

release/v3.2.0

↓

Testing

↓

Git Tag

v3.2.0

↓

Docker Image

banking-app:v3.2.0

↓

Jenkins Pipeline

↓

Deploy to Amazon EKS

↓

Production

↓

Monitoring

↓

Successful Release

---

# 23. Interview Questions

1. What is Semantic Versioning?
2. Explain MAJOR.MINOR.PATCH.
3. Why avoid "latest" Docker image?
4. What is a Git Tag?
5. Difference between Branch and Version.
6. What is Release Candidate?
7. How do you rollback a release?
8. Why version Terraform modules?
9. Why version Jenkins pipelines?
10. How do you track deployed versions?
11. What is the purpose of release notes?
12. Explain your project's versioning strategy.

---

# 24. Key Takeaways

- Every production release must have a unique version.
- Semantic Versioning makes releases predictable and easier to manage.
- Git Tags, Docker image tags, and Kubernetes image versions should always match.
- Never rely on the `latest` tag in production environments.
- Proper versioning enables automated deployments, safe rollbacks, and complete release traceability.
- Versioning is a critical part of enterprise DevOps and Release Management.

---

# 25. Versioning Strategy Used in ERMP

| Component | Versioning Method |
|------------|-------------------|
| Git Repository | Git Tags |
| Application | Semantic Versioning |
| Docker Images | Semantic Versioning |
| Kubernetes | Image Tags |
| Terraform Modules | Git Tags |
| Ansible Playbooks | Git Version Control |
| Jenkins Pipeline | Git Version Control |
| Releases | Release Notes + Git Tags |

---

# 26. Conclusion

The ERMP project follows a standardized versioning strategy across source code, infrastructure, configuration management, container images, and deployments. Consistent versioning ensures traceability, automation, stability, and rapid rollback capabilities, making software delivery reliable and production-ready.