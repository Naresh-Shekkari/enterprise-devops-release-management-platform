# GitHub Webhooks

**Project:** Enterprise DevOps Release Management Platform (ERMP)

**Company:** ABC Bank Pvt Ltd

**Document Version:** v1.0

**Author:** Naresh Shekkari

---

# 1. Objective

The purpose of this document is to explain GitHub Webhooks and how they automate Continuous Integration (CI) by notifying external systems whenever changes occur in a GitHub repository.

In our ERMP project, GitHub Webhooks automatically notify Jenkins whenever developers push code or merge Pull Requests.

This eliminates manual builds and enables a fully automated CI/CD pipeline.

---

# 2. What is a GitHub Webhook?

A GitHub Webhook is an HTTP callback.

Whenever a configured event occurs inside a GitHub repository, GitHub automatically sends an HTTP POST request to another application.

That application can be:

- Jenkins
- GitHub Actions
- SonarQube
- Slack
- Microsoft Teams
- Jira
- Custom APIs

Think of it as:

"GitHub automatically informing another application that something has happened."

---

# 3. Why Do We Need Webhooks?

Without Webhooks

Developer

↓

Push Code

↓

Inform DevOps Team

↓

DevOps Logs into Jenkins

↓

Clicks "Build Now"

↓

Pipeline Starts

Problems:

❌ Manual process

❌ Delay

❌ Human error

❌ Not scalable

With Webhooks

Developer

↓

Push Code

↓

GitHub

↓

Webhook

↓

Jenkins

↓

Pipeline Starts Automatically

No manual intervention required.

---

# 4. How Webhooks Work

```
Developer

↓

Git Push

↓

GitHub Repository

↓

Webhook Event

↓

HTTP POST Request

↓

Jenkins Server

↓

Pipeline Triggered

↓

Build

↓

Test

↓

Docker Build

↓

Deploy
```

---

# 5. Webhook Communication

GitHub sends an HTTP POST request.

Example

```
POST /github-webhook/

Host: jenkins.abcbank.com

Content-Type: application/json
```

Payload contains:

- Repository Name
- Branch
- Commit ID
- Commit Message
- Author
- Event Type
- Timestamp

---

# 6. Events Supported by GitHub Webhooks

Common events:

- Push
- Pull Request
- Pull Request Review
- Release
- Create Branch
- Delete Branch
- Tag Creation
- Issue Creation
- Issue Comment
- Workflow Completed

In our project we mainly use:

- Push
- Pull Request
- Release

---

# 7. Enterprise CI/CD Flow

```
Developer

↓

Git Commit

↓

Git Push

↓

GitHub

↓

Webhook

↓

Jenkins

↓

Checkout Code

↓

Maven Build

↓

JUnit Tests

↓

SonarQube Scan

↓

Docker Build

↓

Push Docker Image to Amazon ECR

↓

Terraform Validation

↓

Ansible Configuration

↓

Deploy to Amazon EKS
```

---

# 8. Example Scenario

Developer fixes Login Bug.

Step 1

```
git add .

git commit -m "Fixed Login Timeout"

git push origin feature/login
```

Step 2

GitHub detects Push.

↓

Webhook fires.

↓

Jenkins receives notification.

↓

Pipeline starts automatically.

No manual action required.

---

# 9. Webhook Payload

GitHub sends JSON.

Example

```json
{
  "repository": {
      "name": "ERMP"
  },
  "ref": "refs/heads/develop",
  "after": "6a9b28f",
  "pusher": {
      "name": "Naresh"
  }
}
```

Jenkins reads this payload and starts the appropriate pipeline.

---

# 10. Jenkins Configuration

In Jenkins

New Pipeline

↓

Build Triggers

↓

Enable

✔ GitHub hook trigger for GITScm polling

This allows Jenkins to accept webhook requests.

---

# 11. GitHub Configuration

Repository

↓

Settings

↓

Webhooks

↓

Add Webhook

Configure:

Payload URL

```
http://jenkins.abcbank.com/github-webhook/
```

Content Type

```
application/json
```

Events

✔ Push

✔ Pull Request

Secret

Configured

↓

Save

---

# 12. Webhook Secret

To prevent unauthorized requests, configure a secret.

Example

```
ERMP@2026#Webhook
```

GitHub signs each payload.

Jenkins validates the signature.

If signatures don't match,

Request is rejected.

---

# 13. Branch-Based Pipeline Trigger

| Branch | Pipeline |
|----------|----------|
| feature/* | Development Build |
| develop | Integration Build |
| release/* | UAT Deployment |
| hotfix/* | Emergency Deployment |
| main | Production Deployment |

---

# 14. Webhook Retry

If Jenkins is unavailable,

GitHub retries delivery.

Delivery status can be viewed under:

Repository

↓

Settings

↓

Webhooks

↓

Recent Deliveries

Possible statuses:

- Success
- Failed
- Retried

---

# 15. Security Best Practices

- Always use HTTPS.
- Configure Webhook Secret.
- Restrict Jenkins access.
- Validate payload signature.
- Never expose Jenkins publicly without authentication.
- Use Reverse Proxy (NGINX/ALB).
- Enable Audit Logs.

---

# 16. Common Problems

Problem:

Webhook not triggered.

Possible Causes:

- Incorrect Payload URL
- Jenkins Offline
- Firewall Blocking Port
- Invalid Secret
- Wrong Build Trigger
- GitHub Cannot Reach Jenkins

---

# 17. Troubleshooting

Verify:

✔ Jenkins running

✔ GitHub Webhook configured

✔ Payload URL correct

✔ Secret matches

✔ Firewall allows access

✔ Jenkins logs

✔ GitHub Delivery Logs

Useful locations:

Jenkins

Manage Jenkins

↓

System Log

GitHub

Settings

↓

Webhooks

↓

Recent Deliveries

---

# 18. Real Production Scenario

Developer pushes code.

↓

GitHub receives commit.

↓

Webhook triggers Jenkins.

↓

Jenkins performs:

- Checkout
- Maven Build
- Unit Tests
- SonarQube Analysis
- Docker Image Build
- Push Image to Amazon ECR

↓

If successful

↓

Deploy to Development Environment

↓

Slack Notification

↓

QA Testing

Entire workflow is fully automated.

---

# 19. Advantages

- Fully automated builds
- Faster feedback
- Reduced manual effort
- Better developer productivity
- Consistent CI/CD
- Immediate pipeline execution
- Improved deployment reliability

---

# 20. Limitations

- Requires network connectivity
- Jenkins must be accessible
- Misconfigured secrets can block requests
- Large organizations need webhook governance
- Requires proper monitoring

---

# 21. Best Practices

- Use Webhook Secrets.
- Use HTTPS only.
- Keep Payload URLs private.
- Configure branch-based pipelines.
- Monitor failed deliveries.
- Avoid unnecessary webhook events.
- Log webhook activity.
- Protect Jenkins with authentication.

---

# 22. Common Mistakes

❌ Public Jenkins without authentication

❌ No Webhook Secret

❌ Wrong Payload URL

❌ Triggering Production pipeline for every branch

❌ Not checking delivery logs

❌ Using HTTP instead of HTTPS

---

# 23. Interview Questions

1. What is a GitHub Webhook?

2. Why do we use Webhooks?

3. How does Jenkins know new code is pushed?

4. Explain the GitHub → Jenkins flow.

5. Which events trigger Webhooks?

6. What is a Webhook Secret?

7. How do you troubleshoot failed Webhooks?

8. Difference between Poll SCM and GitHub Webhooks.

9. Why is HTTPS recommended?

10. How do branch-based pipelines work?

---

# 24. GitHub Webhooks in ERMP

Our project uses GitHub Webhooks to automate the entire CI/CD pipeline.

Flow:

Developer

↓

Git Push

↓

GitHub Repository

↓

Webhook

↓

Jenkins

↓

Maven

↓

JUnit

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

Slack Notification

---

# 25. Key Takeaways

- GitHub Webhooks eliminate manual pipeline execution.
- Jenkins receives webhook notifications through HTTP POST requests.
- Secure Webhooks using HTTPS and shared secrets.
- Branch-specific Webhooks help implement controlled CI/CD workflows.
- Webhooks are the foundation of modern Continuous Integration.
- Every code push in the ERMP project automatically starts the appropriate pipeline.

---

# 26. Conclusion

GitHub Webhooks are a critical component of the ERMP DevOps architecture. They provide an event-driven mechanism that connects GitHub with Jenkins, enabling automated builds, testing, containerization, infrastructure validation, deployment, and monitoring. By combining GitHub Webhooks with Jenkins, Terraform, Ansible, Docker, Kubernetes, and AWS, the project achieves a fully automated and reliable CI/CD pipeline suitable for enterprise-scale software delivery.