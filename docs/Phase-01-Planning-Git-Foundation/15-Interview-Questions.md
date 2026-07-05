# Interview Questions & Answers

**Project:** Enterprise DevOps Release Management Platform (ERMP)

**Company:** ABC Bank Pvt Ltd

**Document Version:** v1.0

**Author:** Naresh Shekkari

---

# 1. Objective

The purpose of this document is to provide commonly asked DevOps interview questions along with concise, production-oriented answers based on the ERMP project.

This document covers:

- Project Architecture
- Git
- GitHub
- Jenkins
- Maven
- SonarQube
- Docker
- Amazon ECR
- Terraform
- Ansible
- Kubernetes
- AWS
- Monitoring
- Release Management
- CI/CD
- Production Scenarios

---

# 2. Project Overview Questions

### Q1. Explain your project.

Answer:

The project is called **Enterprise DevOps Release Management Platform (ERMP)**.

Its objective is to automate the complete software delivery lifecycle, from developer code commit to production deployment.

The project uses:

- Git & GitHub
- GitHub Webhooks
- Jenkins
- Maven
- JUnit
- SonarQube
- Docker
- Amazon ECR
- Terraform
- AWS
- Ansible
- Amazon EKS (Kubernetes)
- Prometheus
- Grafana
- OpenSearch
- Slack

The pipeline supports:

- Continuous Integration
- Continuous Delivery
- Rolling Deployment
- Version-Based Deployment
- Automated Rollback
- Monitoring
- Logging
- Change Management

---

### Q2. Explain your CI/CD pipeline.

Answer:

Developer

↓

Git Commit

↓

GitHub

↓

Webhook

↓

Jenkins

↓

Build

↓

Test

↓

SonarQube

↓

Docker

↓

Amazon ECR

↓

Terraform

↓

Ansible

↓

Amazon EKS

↓

Monitoring

↓

Production

---

### Q3. What problem does your project solve?

Answer:

- Eliminates manual deployments
- Standardizes releases
- Improves deployment speed
- Reduces production failures
- Enables automated rollback
- Provides monitoring and logging
- Improves release quality

---

# 3. Git Questions

### Q1. What branching strategy do you use?

Answer:

Modified GitFlow.

Branches:

- main
- develop
- feature/*
- release/*
- hotfix/*
- bugfix/*

---

### Q2. Why don't developers commit directly to main?

Answer:

Because production code must remain stable.

All changes go through:

Pull Request

↓

Code Review

↓

CI Validation

↓

Merge

---

### Q3. What is Git Tag?

Answer:

A Git Tag identifies a production release.

Example

v2.3.0

It is used for:

- Rollback
- Release Tracking
- Version Management

---

# 4. GitHub Questions

### Q1. What are GitHub Webhooks?

Answer:

GitHub automatically sends an HTTP POST request to Jenkins whenever configured events (such as Push or Pull Request) occur, allowing the CI/CD pipeline to start automatically.

---

### Q2. What events trigger your pipeline?

- Push
- Pull Request
- Release

---

### Q3. How do you secure Webhooks?

- HTTPS
- Secret Token
- Authentication
- Firewall
- Payload Validation

---

# 5. Jenkins Questions

### Q1. Why Jenkins?

Answer:

- Open Source
- Plugin Ecosystem
- Pipeline as Code
- Kubernetes Support
- Enterprise Adoption

---

### Q2. Explain your Jenkins pipeline.

Stages:

Checkout

↓

Build

↓

Unit Test

↓

SonarQube

↓

Docker Build

↓

Push to ECR

↓

Terraform Validation

↓

Ansible

↓

Deploy to Kubernetes

↓

Health Check

---

### Q3. How do you store secrets?

Answer:

Jenkins Credentials Store integrated with AWS Secrets Manager.

---

# 6. Docker Questions

### Q1. Why Docker?

Answer:

Docker packages the application and its dependencies into a portable image, ensuring the same application runs consistently across Development, QA, UAT, and Production.

---

### Q2. Why not use latest image?

Answer:

Because latest is not deterministic.

We always use versioned images.

Example

banking-app:v2.3.0

---

# 7. Kubernetes Questions

### Q1. Why Kubernetes?

Answer:

- Auto Scaling
- Self Healing
- Rolling Deployment
- High Availability
- Service Discovery

---

### Q2. Explain Rolling Deployment.

Old Pods are replaced gradually.

Users continue using the application.

No downtime occurs.

---

### Q3. How do you rollback?

kubectl rollout undo deployment

or

Deploy previous Docker image version.

---

# 8. Terraform Questions

### Q1. Why Terraform?

Answer:

Infrastructure as Code.

Version Controlled.

Reusable Modules.

Cloud Agnostic.

---

### Q2. Which AWS resources do you create?

- VPC
- EC2
- IAM
- Security Groups
- S3
- ALB
- Amazon EKS
- ECR

---

# 9. Ansible Questions

### Q1. Why Ansible?

Answer:

Agentless configuration management using SSH.

---

### Q2. What does Ansible configure?

- Java
- Docker
- Kubernetes Tools
- Users
- SSH
- Security
- Application Deployment

---

### Q3. Static vs Dynamic Inventory?

Static Inventory:

Hosts entered manually.

Dynamic Inventory:

Hosts automatically discovered from AWS using the aws_ec2 inventory plugin.

---

### Q4. Is Ansible Push or Pull?

Answer:

Ansible uses a **Push-Based Architecture**.

The Control Node initiates the connection over SSH and pushes configurations to Managed Nodes.

---

# 10. AWS Questions

### Q1. Which AWS services are used?

- EC2
- IAM
- VPC
- ALB
- S3
- ECR
- EKS
- CloudWatch

---

### Q2. Why Amazon ECR?

Secure private Docker registry integrated with IAM.

---

# 11. Monitoring Questions

### Q1. Which monitoring tools do you use?

- Prometheus
- Grafana
- CloudWatch

---

### Q2. Which logging tool?

OpenSearch.

---

# 12. Release Management Questions

### Q1. Explain your Release Process.

Development

↓

QA

↓

UAT

↓

CAB Approval

↓

Production

↓

Monitoring

---

### Q2. What is CAB?

Change Advisory Board.

Responsible for approving Production Deployments.

---

### Q3. What is Rollback?

Deploying the previous stable version if the new release fails.

---

# 13. Production Scenario Questions

### Q1. Production deployment failed. What will you do?

Answer:

- Stop deployment
- Analyze Jenkins logs
- Check Kubernetes events
- Verify Pods
- Rollback deployment
- Inform stakeholders
- Perform RCA (Root Cause Analysis)

---

### Q2. Jenkins is down.

Answer:

- Verify service status
- Check logs
- Validate disk space
- Restart Jenkins
- Restore from backup if required

---

### Q3. Kubernetes Pods are CrashLoopBackOff.

Answer:

- kubectl describe pod
- kubectl logs
- Verify ConfigMaps
- Verify Secrets
- Check image version
- Fix issue
- Redeploy

---

# 14. Architecture Questions

### Q1. Explain the complete architecture.

Developer

↓

GitHub

↓

Webhook

↓

Jenkins

↓

Maven

↓

SonarQube

↓

Docker

↓

Amazon ECR

↓

Terraform

↓

AWS

↓

Ansible

↓

Amazon EKS

↓

Prometheus

↓

Grafana

↓

OpenSearch

↓

Slack

---

# 15. Best Practices

- Never commit directly to main.
- Use Pull Requests.
- Version Docker images.
- Automate deployments.
- Keep rollback ready.
- Monitor every deployment.
- Scan images before deployment.
- Store secrets securely.

---

# 16. Common Interview Mistakes

❌ Explaining only theory.

❌ Unable to explain project architecture.

❌ Not knowing deployment flow.

❌ Ignoring rollback strategy.

❌ Not understanding Kubernetes basics.

❌ Confusing CI with CD.

❌ Forgetting monitoring and logging.

---

# 17. Quick Revision Sheet

Remember this order:

Developer

↓

GitHub

↓

Webhook

↓

Jenkins

↓

Build

↓

SonarQube

↓

Docker

↓

Amazon ECR

↓

Terraform

↓

AWS

↓

Ansible

↓

Kubernetes

↓

Prometheus

↓

Grafana

↓

OpenSearch

↓

Production

---

# 18. Top 50 Most Asked Interview Questions

### Git (5)

1. What is GitFlow?
2. What is Rebase?
3. Cherry-pick vs Merge?
4. Git Tags?
5. Resolve Merge Conflicts?

### GitHub (5)

6. Branch Protection?
7. Pull Requests?
8. Webhooks?
9. GitHub Actions vs Jenkins?
10. Repository Security?

### Jenkins (5)

11. Pipeline?
12. Jenkinsfile?
13. Credentials?
14. Shared Library?
15. Agents?

### Docker (5)

16. Dockerfile?
17. Multi-stage Build?
18. Docker Volumes?
19. Networking?
20. Docker Compose?

### Kubernetes (5)

21. Pod?
22. Deployment?
23. Service?
24. Ingress?
25. ConfigMap vs Secret?

### Terraform (5)

26. State File?
27. Modules?
28. Remote Backend?
29. Workspaces?
30. Lifecycle?

### Ansible (5)

31. Roles?
32. Inventory?
33. Dynamic Inventory?
34. Vault?
35. Handlers?

### AWS (5)

36. VPC?
37. IAM?
38. ALB?
39. EKS?
40. ECR?

### Monitoring (5)

41. Prometheus?
42. Grafana?
43. Alerts?
44. OpenSearch?
45. CloudWatch?

### Production (5)

46. Rollback?
47. Zero Downtime?
48. Blue-Green Deployment?
49. Disaster Recovery?
50. Change Management?

---

# 19. Key Takeaways

- Interviewers expect practical answers backed by real project experience.
- Understand the complete CI/CD flow from code commit to production.
- Be prepared to explain why each tool was selected and how it integrates with the rest of the platform.
- Production scenarios, troubleshooting, release management, monitoring, and rollback strategies are frequently discussed.
- Confidence comes from understanding the complete architecture rather than memorizing definitions.

---

# 20. Conclusion

This document serves as the primary interview preparation guide for the Enterprise DevOps Release Management Platform (ERMP). By mastering these questions and answers, you will be able to confidently explain the architecture, tools, workflows, troubleshooting approaches, and production practices used in a modern enterprise DevOps environment.